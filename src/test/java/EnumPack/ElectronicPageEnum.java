package EnumPack;
public enum ElectronicPageEnum {
    Computers("Computers"),
    firstName("FirstName"),
    lastName("LastName"),
    email("Email"),
    company("Company"),
    password("Password"),
    checkout("checkout"),
    DOB("DateOfBirthDay"),
    DOBM("DateOfBirthMonth"),
    DOBY("DateOfBirthYear"),
    confrmpass("ConfirmPassword"),
    Agree("termsofservice"),
    ChoseContry("BillingNewAddress.CountryId"),
    Choosestate("BillingNewAddress.StateProvinceId");

    private String name;
    ElectronicPageEnum(String name)//constructor
    {
        this.name = name;
    }
    public String getResourcesName() //method
    {
        return name;
    }

}


