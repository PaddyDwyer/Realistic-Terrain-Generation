package rtg.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWildWheat extends WorldGenerator
{
	private Block farmtype;
	
	/**
	 * 
	 * 0 = potatoes, 1 = carrots, 2 = wheat
	 * 
	 */
    public WorldGenWildWheat(int type)
    {
    	farmtype = type == 0 ? Blocks.potatoes : type == 1 ? Blocks.carrots : Blocks.wheat;
    }

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
    	
    	for(int j = 0; j < 4; j++)
    	{
        	b = world.getBlockState(pos.add(j == 0 ? -1 : j == 1 ? 1 : 0, 0, j == 2 ? -1 : j == 3 ? 1 : 0)).getBlock();
        	if(b.getMaterial() != Material.ground && b.getMaterial() != Material.grass)
        	{
        		return false;
        	}
    	}
    	
    	int rx, ry, rz;
    	for(int i = 0; i < 30; i++)
    	{
    		rx = rand.nextInt(5) - 2;
    		ry = rand.nextInt(2) - 1;
    		rz = rand.nextInt(5) - 2;
    		BlockPos pos1 = pos.add(rx, ry, rz);
    		b = world.getBlockState(pos1).getBlock();
    		
    		if((b == Blocks.grass || b == Blocks.dirt) && world.isAirBlock(pos1.up()))
    		{
    			world.setBlockState(pos1, Blocks.farmland.getStateFromMeta(rand.nextInt(4) + 4), 0);
    			world.setBlockState(pos1.up(), farmtype.getStateFromMeta(rand.nextInt(4) + 4), 0);
    		}
    	}
    	
    	world.setBlockState(pos, Blocks.water.getDefaultState());
    	return true;
    }
}
