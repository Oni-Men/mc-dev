package net.minecraft.server;

public class ItemSeedFood extends ItemFood {

    private Block b;
    private Block c;

    public ItemSeedFood(int i, float f, Block block, Block block1) {
        super(i, f, false);
        this.b = block;
        this.c = block1;
    }

    public boolean interactWith(ItemStack itemstack, EntityHuman entityhuman, World world, int i, int j, int k, int l, float f, float f1, float f2) {
        if (l != 1) {
            return false;
        } else if (entityhuman.a(i, j, k, l, itemstack) && entityhuman.a(i, j + 1, k, l, itemstack)) {
            if (world.getType(i, j, k) == this.c && world.isEmpty(i, j + 1, k)) {
                world.setTypeUpdate(i, j + 1, k, this.b);
                --itemstack.count;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
