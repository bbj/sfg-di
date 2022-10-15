package com.bbj.pets;

//commented as we assume it comes from a 2rd party library
//@Service
//@Profile({"dog", "default"})
public class DogPetService implements PetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}
