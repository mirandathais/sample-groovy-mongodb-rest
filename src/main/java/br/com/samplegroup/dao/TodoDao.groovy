package br.com.samplegroup.dao

import com.google.gson.Gson
import com.mongodb.DBCollection

class TodoDao extends DAO{

    DBCollection collection

    TodoDao() {
        super()
        this.collection = db.getCollection("todo")
    }

    @Override
    Object insert(Object obj) {
        def doc = toBasicDBObject(obj)
        collection.insert(doc)
        doc.toString()
    }

    @Override
    Object find(Object obj) {
        return null
    }

    @Override
    Object findAll() {
        def docs = collection.find()
        new Gson().toJson(docs)
    }

    @Override
    Object remove(Object obj) {
        return null
    }

    @Override
    Object findAndRemove(Object obj) {
        return null
    }

    @Override
    Object update(Object obj) {
        return null
    }
}
