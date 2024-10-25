package edu.odu.cs.cs330.items;

import java.util.Objects;

/**
 * This class represents one Consumable Item--as found in most video games.
 * This includes food.
 * 
 * Consumable Items must be stackable.
 */
@SuppressWarnings({
        "PMD.CloneMethodReturnTypeMustMatchClassName",
        "PMD.CloneThrowsCloneNotSupportedException",
        "PMD.LawOfDemeter",
        "PMD.OnlyOneReturn",
        "PMD.ProperCloneImplementation",
        "PMD.MethodArgumentCouldBeFinal",
        "PMD.LocalVariableCouldBeFinal",
        "PMD.BeanMembersShouldSerialize"
})
public class Consumable extends Item {
    /**
     * Format used to generate a printable representation.
     */
    public static final String FMT_STR = String.join(
            "",
            "  Nme: %s%n",
            "  Eft: %s%n",
            "  Use: %d%n");

    /**
     * The effect "buff" or "debuff" that is received when using this item.
     */
    protected String effect;

    /**
     * The number of times this item can be used.
     */
    protected int uses;

    /**
     * Default to a Consumable Item with an empty name, no effect and zero
     * uses.
     */
    public Consumable() {
        super("[Placeholder]");
        this.effect = "";
        this.uses = 0;
    }

    /**
     * Retrieve the effect.
     * 
     * @return the set effect (i.e., buff or debuff)
     */
    public String getEffect() {
        return this.effect;
    }

    /**
     * Set a new buff or debuff.
     * 
     * @param newEff replacement effect
     */
    public void setEffect(String newEff) {
        this.effect = newEff;
    }

    /**
     * Retrieve permitted number of uses.
     * 
     * @return number of total uses
     */
    public int getNumberOfUses() {
        return this.uses;
    }

    /**
     * Set the number of permitted uses.
     * 
     * @param allowed number of allowed uses
     */
    public void setNumberOfUses(int allowed) {
        this.uses = allowed;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public int requiredNumberOfValues() {
        return 3; // Number of values required to initialize a Consumable object
    }

    @Override
    public void fromTokens(String[] tokens) {
        this.setName(tokens[0]);
        this.setEffect(tokens[1]);
        this.setNumberOfUses(Integer.parseInt(tokens[2]));
    }

    /**
     * Clone--i.e., copy--this Consumable Item.
     */
    @Override
    public Item clone() {
        Consumable cpy = new Consumable();
        cpy.setName(this.getName());
        cpy.setEffect(this.getEffect());
        cpy.setNumberOfUses(this.getNumberOfUses());
        return cpy;
    }

    /**
     * Check for logical equivalence--based on name and effect.
     * 
     * @param rhs object for which a comparison is desired
     */
    @Override
    public boolean equals(Object rhs) {
        if (!(rhs instanceof Consumable)) {
            return false;
        }
        Consumable rhsItem = (Consumable) rhs;
        return Objects.equals(this.getName(), rhsItem.getName()) &&
                Objects.equals(this.getEffect(), rhsItem.getEffect());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName(), this.getEffect());
    }
    /**
     * *Print* the Consumable Item.
     */
    @Override
    public String toString() {
        return String.format(
                FMT_STR,
                this.getName(),
                this.getEffect(),
                this.getNumberOfUses());
    }
}
