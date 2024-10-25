package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one tool--as found in most video games. This includes
 * pickaxes and shovels.
 * 
 * Tools may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
@SuppressWarnings({
        "PMD.CloneMethodReturnTypeMustMatchClassName",
        "PMD.CloneThrowsCloneNotSupportedException",
        "PMD.LawOfDemeter",
        "PMD.OnlyOneReturn",
        "PMD.ProperCloneImplementation",
        "PMD.MethodArgumentCouldBeFinal",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.ShortClassName",
})
public class Tool extends Equippable {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
            "",
            "  Nme: %s%n",
            "  Dur: %d%n",
            "  Spd: %d%n",
            "  Mtl: %s%n",
            "  Mdr: %s (Lvl %d)%n");

    /**
     * Base operation (e.g., harvest/mine) speed.
     */
    protected int speed;

    private boolean stackable;

    /**
     * Default to an unstackable tool with zero speed.
     */
    public Tool() {
        super();
        this.stackable = false;
        this.speed = 0;
    }

    /**
     * Retrieve tool speed.
     * 
     * @return how quickly a tool operates
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Set tool speed.
     * 
     * @param spd new speed
     */
    public void setSpeed(int spd) {
        this.speed = spd;
    }

    @Override
    public int requiredNumberOfValues() {
        return 6; // Number of values required to initialize a Tool object
    }

    @Override
    public void fromTokens(String[] tokens) {
        this.setName(tokens[0]);
        this.setMaterial(tokens[1]);
        this.setDurability(Integer.parseInt(tokens[2]));
        this.setSpeed(Integer.parseInt(tokens[3]));
        this.setModifier(tokens[4]);
        this.setModifierLevel(Integer.parseInt(tokens[5]));
    }

    /**
     * Clone--i.e., copy--this Tool.
     */
    @Override
    public Item clone() {
        Tool cpy = new Tool();
        cpy.setName(this.getName());
        cpy.setDurability(this.getDurability());
        cpy.setSpeed(this.getSpeed());
        cpy.setMaterial(this.getMaterial());
        cpy.setModifier(this.getModifier());
        cpy.setModifierLevel(this.getModifierLevel());
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name, speed, material, modifier,
     * and modifierLevel.
     * 
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(final Object rhs) {
        if (this == rhs) {
            return true;
        }
        if (!(rhs instanceof Tool)) {
            return false;
        }
        Tool rhsItem = (Tool) rhs;
        return Objects.equals(this.getName(), rhsItem.getName()) &&
                this.getSpeed() == rhsItem.getSpeed() &&
                Objects.equals(this.getMaterial(), rhsItem.getMaterial()) &&
                Objects.equals(this.getModifier(), rhsItem.getModifier()) &&
                this.getModifierLevel() == rhsItem.getModifierLevel();
    }

    /**
     * Compute hashCode using name, speed, material, modifier, and modifierLevel.
     * Durability is not considered in hashing to ensure consistency with equals.
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                this.getName(),
                this.getSpeed(),
                this.getMaterial(),
                this.getModifier(),
                this.getModifierLevel());
    }

    /**
     * *Print* a Tool.
     */
    @Override
    public String toString() {
        return String.format(
                FMT_STR,
                this.getName(),
                this.getDurability(),
                this.getSpeed(),
                this.getMaterial(),
                this.getModifier(),
                this.getModifierLevel());
    }
}
