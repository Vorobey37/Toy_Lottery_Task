public class Toy  {
    
    private int id;
    private String name;
    private int appearanceChance;



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getAppearanceChance() {
        return appearanceChance;
    }



    public void setAppearanceChance(int appearanceChance) {
        this.appearanceChance = appearanceChance;
    }

    @Override
    public String toString() {
        return name;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + appearanceChance;
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Toy other = (Toy) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (appearanceChance != other.appearanceChance)
            return false;
        return true;
    }
}
