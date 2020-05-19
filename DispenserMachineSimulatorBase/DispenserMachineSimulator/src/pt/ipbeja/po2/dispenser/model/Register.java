package pt.ipbeja.po2.dispenser.model;

/**
 * Created by: Rodrigo Fernandes, 17845
 * Date: 29/04/2020 @ 11:12
 * For the project: DispenserMachineSimulator
 */

public class Register {
    private String model;
    private String companyName;
    private int year;

    public Register(String model, String companyName, int year) {
        this.model = model;
        this.companyName = companyName;
        this.year = year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
