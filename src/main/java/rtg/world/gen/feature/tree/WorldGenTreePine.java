package rtg.world.gen.feature.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class WorldGenTreePine extends WorldGenerator
{
	private int height;
	private int metadata;
	
    public WorldGenTreePine(int h, int m)
    {
        super(false);
        
        height = h;
        metadata = m;
    }

    public boolean generate(World world, Random rand, BlockPos pos)
    {
        int l = rand.nextInt(height * 2) + height * 2;
        int i1 = height + rand.nextInt(height);
        int j1 = l - i1;
        int k1 = 2 + rand.nextInt(2);
        boolean flag = true;

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        if (y >= 1 && y + l + 1 <= 256)
        {
            int i2;
            int l3;

            for (int l1 = y; l1 <= y + 1 + l && flag; ++l1)
            {
                boolean flag1 = true;

                if (l1 - y < i1)
                {
                    l3 = 0;
                }
                else
                {
                    l3 = k1;
                }

                for (i2 = x - l3; i2 <= x + l3 && flag; ++i2)
                {
                    for (int j2 = z - l3; j2 <= z + l3 && flag; ++j2)
                    {
                        if (l1 >= 0 && l1 < 256)
                        {
                        	BlockPos pos1 = new BlockPos(i2, l1, j2);
                            Block block = world.getBlockState(pos1).getBlock();

                            if (!block.isAir(world, pos1) && !block.isLeaves(world, pos1) && block != Blocks.snow_layer)
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block1 = world.getBlockState(pos.down()).getBlock();

                boolean isSoil = block1.canSustainPlant(world, pos.down(), EnumFacing.UP, (BlockSapling)Blocks.sapling);
                if (isSoil && y < 256 - l - 1)
                {
                    block1.onPlantGrow(world, pos.down(), pos);
                    l3 = rand.nextInt(2);
                    i2 = 1;
                    byte b0 = 0;
                    int k2;
                    int i4;

                    for (i4 = 0; i4 <= j1; ++i4)
                    {
                        k2 = y + l - i4;

                        for (int l2 = x - l3; l2 <= x + l3; ++l2)
                        {
                            int i3 = l2 - x;

                            for (int j3 = z - l3; j3 <= z + l3; ++j3)
                            {
                                int k3 = j3 - z;
                                BlockPos pos1 = new BlockPos(l2, k2, j3);

                                if ((Math.abs(i3) != l3 || Math.abs(k3) != l3 || l3 <= 0) && world.getBlockState(pos1).getBlock().canBeReplacedByLeaves(world, pos1))
                                {
                                    world.setBlockState(pos1, Blocks.leaves.getStateFromMeta(metadata), 0);
                                }
                            }
                        }

                        if (l3 >= i2)
                        {
                            l3 = b0;
                            b0 = 1;
                            ++i2;

                            if (i2 > k1)
                            {
                                i2 = k1;
                            }
                        }
                        else
                        {
                            ++l3;
                        }
                    }

                    i4 = rand.nextInt(3);

                    for (k2 = 0; k2 < l - i4; ++k2)
                    {
                        Block block2 = world.getBlockState(pos.up(k2)).getBlock();

                        if (block2.isAir(world, pos.up(k2)) || block2.isLeaves(world, pos.up(k2)) || block2 == Blocks.snow_layer)
                        {
                        	world.setBlockState(pos.up(k2), Blocks.log.getDefaultState(), 0);
                        }
                    }
                    
                    if(height > 4)
                    {
                    	createTrunk(world, rand, pos);
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
    
    private void createTrunk(World world, Random rand, BlockPos pos)
    {
    	int[] vec = new int[]{0,0, 1,0, 0,1, -1,0, 0,-1};
    	BlockPos pos1;
    	for(int t = 0; t < 5; t++)
    	{    	
    		pos1 = pos.up(rand.nextInt(3));
    		while(pos1.getY() > pos.getY() - 1)
    		{
    			if(world.getBlockState(pos1.add(vec[t * 2], 0, vec[t * 2 + 1])).getBlock() == Blocks.grass)
    			{
    				break;
    			}
    			world.setBlockState(pos1.add(vec[t * 2], 0, vec[t * 2 + 1]), Blocks.log.getStateFromMeta(12), 0);
    			pos1.down();
    		}
    	}
    }
}
