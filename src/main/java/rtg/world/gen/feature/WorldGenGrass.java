package rtg.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGrass extends WorldGenerator
{
	private BlockBush block;
	private int metadata;

    public WorldGenGrass(Block b, int m)
    {
		block = b;
		metadata = m;
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
    		pos = pos.down();
    	}
    	
    	if(block == Blocks.double_plant)
    	{
            for (int l = 0; l < 64; ++l)
            {
            	BlockPos blockPos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
                
                if (world.isAirBlock(blockPos1) && blockPos1.getY() < 254 && Blocks.double_plant.canPlaceBlockAt(world, blockPos1))
                {
                    Blocks.double_plant.placeAt(world, blockPos1, BlockDoublePlant.EnumPlantType.byMetadata(metadata), 0);
                }
            }
    	}
    	else
    	{
            for (int l = 0; l < 128; ++l)
            {
            	BlockPos blockPos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

                if (world.isAirBlock(blockPos1) && block.canBlockStay(world, blockPos1, block.getDefaultState()))
                {
                    world.setBlockState(blockPos1, block.getStateFromMeta(metadata), 0);
                }
            }
    	}
    	return true;
    }
}
