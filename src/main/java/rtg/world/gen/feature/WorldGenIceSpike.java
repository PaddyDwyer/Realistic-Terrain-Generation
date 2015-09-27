package rtg.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenIceSpike extends WorldGenerator
{
//    public boolean generate(World world, Random rand, BlockPos pos)
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        while (world.isAirBlock(pos) && pos.getY() > 2)
        {
            pos = pos.down();
        }

        Block block = world.getBlockState(pos).getBlock();
        if (block != Blocks.snow && block != Blocks.snow_layer)
        {
            return false;
        }
        else
        {
            pos = pos.up(rand.nextInt(4));
            int l = rand.nextInt(4) + 7;
            int i1 = l / 4 + rand.nextInt(2);

            if (i1 > 1 && rand.nextInt(60) == 0)
            {
                pos = pos.up(10 + rand.nextInt(30));
            }

            int j1;
            int k1;
            int l1;

            for (j1 = 0; j1 < l; ++j1)
            {
                float f = (1.0F - (float)j1 / (float)l) * (float)i1;
                k1 = MathHelper.ceiling_float_int(f);

                for (l1 = -k1; l1 <= k1; ++l1)
                {
                    float f1 = (float)MathHelper.abs_int(l1) - 0.25F;

                    for (int i2 = -k1; i2 <= k1; ++i2)
                    {
                        float f2 = (float)MathHelper.abs_int(i2) - 0.25F;

                        if ((l1 == 0 && i2 == 0 || f1 * f1 + f2 * f2 <= f * f) && (l1 != -k1 && l1 != k1 && i2 != -k1 && i2 != k1 || rand.nextFloat() <= 0.75F))
                        {
                        	BlockPos pos1 = pos.add(l1, j1, i2);
                            block = world.getBlockState(pos1).getBlock();

                            if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice)
                            {
                                this.func_175906_a(world, pos1, Blocks.packed_ice);
                            }

                            if (j1 != 0 && k1 > 1)
                            {
                            	pos1 = pos.add(l1, -j1, i2);
                                block = world.getBlockState(pos1).getBlock();

                                if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice)
                                {
                                    this.func_175906_a(world, pos1, Blocks.packed_ice);
                                }
                            }
                        }
                    }
                }
            }

            j1 = i1 - 1;

            if (j1 < 0)
            {
                j1 = 0;
            }
            else if (j1 > 1)
            {
                j1 = 1;
            }

            for (int j2 = -j1; j2 <= j1; ++j2)
            {
                k1 = -j1;

                while (k1 <= j1)
                {
                    l1 = pos.getY() - 1;
                    int k2 = 50;

                    if (Math.abs(j2) == 1 && Math.abs(k1) == 1)
                    {
                        k2 = rand.nextInt(5);
                    }

                    while (true)
                    {
                        if (l1 > 50)
                        {
                        	BlockPos pos1 = pos.add(j2, -1, k1);
                            block = world.getBlockState(pos1).getBlock();

                            if (block.getMaterial() == Material.air || block == Blocks.dirt || block == Blocks.snow || block == Blocks.ice || block == Blocks.packed_ice)
                            {
                                this.func_175906_a(world, pos1, Blocks.packed_ice);
                                --l1;
                                --k2;

                                if (k2 <= 0)
                                {
                                    l1 -= rand.nextInt(5) + 1;
                                    k2 = rand.nextInt(5);
                                }

                                continue;
                            }
                        }

                        ++k1;
                        break;
                    }
                }
            }

            return true;
        }
    }
}