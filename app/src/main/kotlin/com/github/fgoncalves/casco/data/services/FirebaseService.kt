package com.github.fgoncalves.casco.data.services

import com.github.fgoncalves.casco.data.models.Root
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface FirebaseService {
    /**
     * Return the root element for the DB
     */
    fun getRoot(): Single<Root>
}

class FirebaseServiceImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
) : FirebaseService {
    override fun getRoot(): Single<Root> =
        Single.create<Root> {
            it.takeUnless { it.isDisposed }
                ?.let { emitter ->
                    firebaseDatabase.reference.addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(databaseError: DatabaseError) {
                            emitter.onError(databaseError.toException())
                        }

                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            dataSnapshot.getValue(Root::class.java)?.let {
                                emitter.onSuccess(it)
                            } ?: emitter.onError(RuntimeException("Got null while deserializing root"))
                        }
                    })
                }
        }.subscribeOn(Schedulers.io())
}
