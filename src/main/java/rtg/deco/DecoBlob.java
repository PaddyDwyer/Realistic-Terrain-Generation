package rtg.deco;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import rtg.config.ConfigRTG;
import rtg.util.RandomUtil;

public class DecoBlob extends WorldGenerator
{
    private Block field_150545_a;
    private int field_150544_b;
    private static final String __OBFID = "CL_00000402";

    public DecoBlob(Block p_i45450_1_, int p_i45450_2_)
    {
        super(false);
        this.field_150545_a = p_i45450_1_;
        this.field_150544_b = p_i45450_2_;
    }

    public boolean generate(World worldIn, Random p_180709_2_, BlockPos p_180709_3_)
    {
        if ((field_150545_a == Blocks.mossy_cobblestone || field_150545_a == Blocks.cobblestone) && !ConfigRTG.enableCobblestoneBoulders && !shouldGenerateCobblestoneBoulder()) {
            return false;
        }

        while (true)
        {
            if (p_180709_3_.getY() > 3)
            {
                label63:
                {
                    if (!worldIn.isAirBlock(p_180709_3_.down()))
                    {
                        Block block = worldIn.getBlockState(p_180709_3_.down()).getBlock();

                        if (block == Blocks.grass || block == Blocks.dirt || block == Blocks.stone || block == Blocks.gravel || block == Blocks.sand)
                        {
                            break label63;
                        }
                    }

                    p_180709_3_ = p_180709_3_.down();
                    continue;
                }
            }

            if (p_180709_3_.getY() <= 3)
            {
                return false;
            }

            int k2 = this.field_150544_b;

            for (int l = 0; k2 >= 0 && l < 3; ++l)
            {
                int i1 = k2 + p_180709_2_.nextInt(2);
                int j1 = k2 + p_180709_2_.nextInt(2);
                int k1 = k2 + p_180709_2_.nextInt(2);
                float f = (float)(i1 + j1 + k1) * 0.333F + 0.5F;
                
                Iterator iterator = BlockPos.getAllInBox(p_180709_3_.add(-i1, -j1, -k1), p_180709_3_.add(i1, j1, k1)).iterator();

                while (iterator.hasNext())
                {
                    BlockPos blockpos1 = (BlockPos)iterator.next();

                    if (blockpos1.distanceSq(p_180709_3_) <= (double)(f * f))
                    {
                        worldIn.setBlockState(blockpos1, this.field_150545_a.getDefaultState(), 4);
                    }
                }

                p_180709_3_ = p_180709_3_.add(-(i1 + 1) + p_180709_2_.nextInt(2 + i1 * 2), 0 - p_180709_2_.nextInt(2), -(i1 + 1) + p_180709_2_.nextInt(2 + i1 * 2));
            }

            return true;
        }
    }
    
    public static boolean shouldGenerateCobblestoneBoulder()
    {
    	int chance = ConfigRTG.cobblestoneBoulderChance;
    	chance = (chance < 1) ? 1 : ((chance > 100) ? 100 : chance);
    	
    	int random = RandomUtil.getRandomInt(1, chance);
    	
    	boolean booGenerate = (random == 1) ? true : false;
    	
    	//Logger.info("Random = %d; Generate? = %b", random, booGenerate);
    	
    	return booGenerate;
    }
}