package com.example.interview_prep.MMT;

import java.util.*;

public class demo {
    static class Entity<K,V>{
        private String id;
        private K place;
        private V age;
        Entity() {

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public K getPlace() {
            return place;
        }

        public void setPlace(K place) {
            this.place = place;
        }

        public V getAge() {
            return age;
        }

        public void setAge(V age) {
            this.age = age;
        }
    }



    public static void main(String[] args) throws Exception {
        Map<String,Object> oneInput = new HashMap<>();
        Object a = 32;
        oneInput.put("age",a);
        oneInput.put("place","Bangalore");

        Map<String,Entity> map = new HashMap<>();


        try {
            add("Ashish", oneInput, map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(map);

    }

    static void add(String key,  Map<String,Object> values, Map<String,Entity> map ) throws Exception {
        //not present
        if(!map.containsKey(key)) {
            //i need to put entry in map
            Entity entity = new Entity();
            entity.setId(key);
            for(Map.Entry<String,Object> entry: values.entrySet()) {
                String keyI = entry.getKey();
                Object keyV = entry.getValue();
                if(Objects.equals(keyI, "age")) {
                    if(!(keyV instanceof Integer)) {
                        throw new Exception("age class mismatch");
                    } else {
                        entity.setAge(Integer.parseInt(keyV.toString()));
                    }
                }

                if(Objects.equals(keyI, "place")) {
                    if(!(keyV instanceof String)) {
                        throw new Exception("place class mismatch");
                    } else {
                        entity.setAge(Integer.parseInt(keyV.toString()));
                    }
                }

            }
            map.put(key,entity);
        } else {
            //
            Entity entity = map.get(key);

            //validate the input
            for(Map.Entry<String,Object> entry: values.entrySet()) {
                String keyI = entry.getKey();
                Object keyV = entry.getValue();
                if(Objects.equals(keyI, "age")) {
                    if(!keyV.getClass().isInstance(entity.getAge().getClass())) {
                        throw new Exception("class mismatch");
                    } else {
                        entity.setAge(Integer.parseInt(keyV.toString()));
                    }
                }

                if(Objects.equals(keyI, "place")) {
                    if(!keyV.getClass().isInstance(entity.getPlace().getClass())) {
                        throw new Exception("class mismatch");
                    } else {
                        entity.setPlace(keyV.toString());
                    }
                }
            }

        }

        //present
    }

    static void delete(String id,Map<String,Entity> map) {
        map.remove(id);
    }

    static Entity fetch(String id, Map<String,Entity> map) {
        return map.get(id);
    }




//    key-value store
//
//    Key : String,
//    Value : List of Node<K,V> where K and V both are objects
//
//    once inserted of any type key and it's value inside this list it's value type should not get changed.
//            Ex : Ashish : {age:32, place:"Bangalore"} -> allowed in first turn.
//    Ashish : {age:"thirty two"} -> not allowed and return error.
//
//
//    CRUD operations for this key-value store.
//    Make it thread safe operations.



}
