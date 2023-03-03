package com.wanderlust.wanderlust.external.carRental.carData.model;

public enum Make {
    BUICK("Buick"),
    MINI("MINI"),
    VOLVO("Volvo"),
    FORD("Ford"),
    HUMMER("HUMMER"),
    GMC("GMC"),
    SUBARU("Subaru"),
    MITSUBISHI("Mitsubishi"),
    DODGE("Dodge"),
    NISSAN("Nissan"),
    HONDA("Honda"),
    LINCOLN("Lincoln"),
    HYUNDAI("Hyundai"),
    BMW("BMW"),
    BENTLEY("Bentley"),
    LEXUS("Lexus"),
    CHEVROLET("Chevrolet"),
    JAGUAR("Jaguar"),
    MERCEDES_BENZ("Mercedes-Benz"),
    VOLKSWAGEN("Volkswagen"),
    ASTON_MARTIN("Aston Martin"),
    LAND_ROVER("Land Rover"),
    PONTIAC("Pontiac"),
    CADILLAC("Cadillac"),
    FIAT("FIAT"),
    SAAB("Saab"),
    KIA("Kia"),
    LAMBORGHINI("Lamborghini"),
    AUDI("Audi"),
    JEEP("Jeep"),
    MAZDA("MAZDA"),
    SUZUKI("Suzuki"),
    TOYOTA("Toyota"),
    ACURA("Acura"),
    SATURN("Saturn"),
    CHRYSLER("Chrysler"),
    ISUZU("Isuzu"),
    FERRARI("Ferrari"),
    TESLA("Tesla"),
    INFINITI("INFINITI"),
    OLDSMOBILE("Oldsmobile"),
    RAM("Ram"),
    EAGLE("Eagle"),
    PORSCHE("Porsche"),
    MERCURY("Mercury"),
    SCION("Scion"),
    LOTUS("Lotus"),
    PLYMOUTH("Plymouth"),
    FREIGHTLINER("Freightliner"),
    ROLLS_ROYCE("Rolls-Royce"),
    SRT("SRT"),
    MAYBACH("Maybach"),
    ALFA_ROMEO("Alfa Romeo"),
    GEO("Geo"),
    SMART("smart"),
    DAEWOO("Daewoo"),
    MASERATI("Maserati"),
    DAIHATSU("Daihatsu"),
    GENESIS("Genesis"),
    MCLAREN("McLaren"),
    FISKER("Fisker"),
    PANOZ("Panoz");

    private final String description;

    Make(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


