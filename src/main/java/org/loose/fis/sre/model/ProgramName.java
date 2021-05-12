package org.loose.fis.sre.model;

        import java.util.Objects;

public class ProgramName {
    private String name;
    private String category;
    private int price;

    public ProgramName(String name, String category,int price ) {
        this.name = name;
        this.category=category;
        this.price=price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String name) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramName productName = (ProgramName) o;
        if(!Objects.equals(name, productName.name)) return false;
        return price==0 ? price== productName.price : productName.price==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String toString(){
        return name;
    }
}
