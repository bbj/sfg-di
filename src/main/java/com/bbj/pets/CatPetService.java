package com.bbj.pets;

//commented as we assume it comes from a 2rd party library
//@Service
//@Profile("cat")
public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}