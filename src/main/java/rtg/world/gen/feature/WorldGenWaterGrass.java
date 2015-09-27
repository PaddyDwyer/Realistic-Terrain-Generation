package rtg.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterGrass extends WorldGenerator
{
	private Block block;
	private int metadata;
	private int minHeight;

    public WorldGenWaterGrass(Block b, int m)
    {
		this(b, m, 10);
    }
    
    public WorldGenWaterGrass(Block b, int m, int mh)
    {
		block = b;
		metadata = m;
		minHeight = mh;
    }

//    public boolean generate(World world, Random rand, BlockPos pos)
    public boolean generate(World world, Random rand, BlockPos pos)
    {
    	while(pos.getY() > 0)
    	{
    		if(!world.isAirBlock(pos) || world.getBlockState(pos).getBlock().isLeaves(world, pos))
    		{
    			break;
    		}
    		
    		if(pos.getY() < minHeight)
    		{
    			return false;
    		}
    		pos = pos.down();
    	}

    	Block b;
    	if(block == Blocks.double_plant)
    	{
	        for (int l = 0; l < 32; ++l)
	        {
	        	BlockPos blockPos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(2) - rand.nextInt(2), rand.nextInt(8) - rand.nextInt(8));
	            
	            b = world.getBlockState(blockPos1.down()).getBlock();
	            if(((b == Blocks.water && world.getBlockState(blockPos1.down(2)).getBlock() == Blocks.sand) || b == Blocks.sand) && world.getBlockState(blockPos1).getBlock() == Blocks.air)
	            {
	            	world.setBlockState(blockPos1.down(), Blocks.grass.getDefaultState(), 0);
	            }
	
	            if (world.isAirBlock(blockPos1) && blockPos1.getY() < 254 && Blocks.double_plant.canPlaceBlockAt(world, blockPos1))
	            {
	                Blocks.double_plant.placeAt(world, blockPos1, BlockDoublePlant.EnumPlantType.byMetadata(metadata), 0);
	            }
	        }
    	}
    	else if(block == Blocks.leaves)
    	{
            for (int l = 0; l < 64; ++l)
            {
	        	BlockPos blockPos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
                
	            b = world.getBlockState(blockPos1.down()).getBlock();
	            if(((b == Blocks.water && world.getBlockState(blockPos1.down(2)).getBlock() == Blocks.sand) || b == Blocks.sand) && world.getBlockState(blockPos1).getBlock() == Blocks.air)
	            {
	            	world.setBlockState(blockPos1, Blocks.grass.getDefaultState(), 0);
	            }
                
                if (world.isAirBlock(blockPos1) && world.getBlockState(blockPos1.down()).getBlock() == Blocks.grass)
                {
                    world.setBlockState(blockPos1, block.getStateFromMeta(metadata), 0);
                }
            }
    	}
		else
		{
            for (int l = 0; l < 128; ++l)
            {
            	BlockPos blockPos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

	            b = world.getBlockState(blockPos1.down()).getBlock();
	            if(((b == Blocks.water && world.getBlockState(blockPos1.down(2)).getBlock() == Blocks.sand) || b == Blocks.sand) && world.getBlockState(blockPos1).getBlock() == Blocks.air)
	            {
	            	world.setBlockState(blockPos1.down(), Blocks.grass.getDefaultState(), 0);
	            }
                
                if (world.isAirBlock(blockPos1) && block.canPlaceBlockAt(world, blockPos1))
                {
                    world.setBlockState(blockPos1, block.getStateFromMeta(metadata), 0);
                }
            }
		}
    	return true;
    }
}
