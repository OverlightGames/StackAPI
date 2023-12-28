package me.higherlevel.stackapi.items;

/**
 * Defines an item that has an overridable method {@link #tick()} that runs every server tick.
 */
public interface TickableItem {
    /**
     * Method that runs every server tick.
     */
    void tick();
}
