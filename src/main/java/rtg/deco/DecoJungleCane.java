package rtg.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoJungleCane extends WorldGenerator 
{
	private int height;
	
    public DecoJungleCane(int h)
    {
    	height = h;
    }

	@Override
//	public boolean generate(World world, Random rand, BlockPos pos)
	public boolean generate(World world, Random rand, BlockPos pos)
	{
    	Block b;
    	while(pos.getY() > 0)
    	{
    		b = world.getBlockState(pos).getBlock();
    		if(!world.isAirBlock(pos) || b.isLeaves(world, pos))
    		{
    			break;
    		}
    		pos = pos.down();
    	}
    	
    	b = world.getBlockState(pos).getBlock();
    	if(b != Blocks.grass && b != Blocks.dirt)
    	{
    		return false;
    	}

    	int j, sx, sz, ra;
    	for(j = 0; j < 4; j++)
    	{
        	b = world.getBlockState(pos.add(j == 0 ? -1 : j == 1 ? 1 : 0, 0, j == 2 ? -1 : j == 3 ? 1 : 0)).getBlock();
        	if(b.getMaterial() != Material.ground && b.getMaterial() != Material.grass)
        	{
        		return false;
        	}
    	}
    	
    	for(j = 0; j < 4; j++)
    	{
    		int x = pos.getX();
    		int y = pos.getY();
    		int z = pos.getZ();
    		sx = j == 0 ? x - 1 : j == 1 ? x + 1 : x;
    		sz = j == 2 ? z - 1 : j == 3 ? z + 1 : z;
    		ra = rand.nextInt(height * 2 + 1) + height;
    		
        	b = world.getBlockState(new BlockPos(sx, y + 1, sz)).getBlock();
        	if(b.getMaterial() == Material.air || b.getMaterial() == Material.vine)
        	{
        		for(int k = 0; k < ra; k++)
        		{
                	b = world.getBlockState(new BlockPos(sx, y + 1 + k, sz)).getBlock();
                	if(b.getMaterial() == Material.air || b.getMaterial() == Material.vine)
                	{
            			world.setBlockState(new BlockPos(sx, y + 1 + k, sz), Blocks.reeds.getDefaultState(), 2);
                	}
                	else
                	{
                		break;
                	}
        		}
        	}
    	}

    	world.setBlockState(pos, Blocks.water.getDefaultState());
    	
    	return true;
	}
}
