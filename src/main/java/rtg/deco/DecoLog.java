package rtg.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoLog extends WorldGenerator
{
	private int logMeta;
	private int leavesMeta;
	private Block logBlock;
	private Block leavesBlock;
	private int logLength;
	
	public DecoLog(int meta, int length, boolean leaves)
	{
		logBlock = meta > 2 ? Blocks.log2 : Blocks.log;
		leavesBlock = meta > 2 ? Blocks.leaves2 : Blocks.leaves;
		meta = meta > 2 ? meta - 2 : meta;
		
		logMeta = meta;
		leavesMeta = leaves ? meta : -1;
		logLength = length < 2 ? 2 : length;
	}

//	public boolean generate(World world, Random rand, BlockPos pos) 
	// TODO: Use EnumFacing to set position and dir stuff
	public boolean generate(World world, Random rand, BlockPos pos) 
	{
    	Block g = world.getBlockState(pos.down()).getBlock();
    	if(g.getMaterial() != Material.ground && g.getMaterial() != Material.grass && g.getMaterial() != Material.sand && g.getMaterial() != Material.rock)
    	{
    		return false;
    	}
    	
		int dir = rand.nextInt(2);
		int dirMeta = 4 + (dir * 4) + logMeta;
		boolean leaves = leavesMeta > -1 ? true : false;
		
		int i;
		Block b;
		int air = 0;
		for(i = 0; i < logLength; i++)
		{
			b = world.getBlockState(pos.add(-(dir == 0 ? 1 : 0), 0, -(dir == 1 ? 1 : 0))).getBlock();
			if(b.getMaterial() != Material.air && b.getMaterial() != Material.vine && b.getMaterial() != Material.plants)
			{
				break;
			}
			
			pos = pos.add(-(dir == 0 ? 1 : 0), 0, -(dir == 1 ? 1 : 0));
			
			if(airCheck(world, rand, pos) > 0)
			{
				return false;
			}
		}
		
		for(i = 0; i < logLength * 2; i++)
		{
			b = world.getBlockState(pos.add((dir == 0 ? 1 : 0), 0, (dir == 1 ? 1 : 0))).getBlock();
			if(b.getMaterial() != Material.air && b.getMaterial() != Material.vine && b.getMaterial() != Material.plants)
			{
				break;
			}
			
			air += airCheck(world, rand, pos);
			if(air > 2)
			{
				return false;
			}

			world.setBlockState(pos, logBlock.getStateFromMeta(dirMeta), 0);

			if(leavesMeta > -1)
			{
				addLeaves(world, rand, dir, pos);
			}
			
			pos = pos.add((dir == 0 ? 1 : 0), 0, (dir == 1 ? 1 : 0));
		}
		
		return true;
	}
	
	private int airCheck(World world, Random rand, BlockPos pos)
	{
		Block b = world.getBlockState(pos.down()).getBlock();
		if(b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.water || b.getMaterial() == Material.plants)
		{
			b = world.getBlockState(pos.down(2)).getBlock();
			if(b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.water || b.getMaterial() == Material.plants)
			{
				return 99;
			}
			return 1;
		}
		
		return 0;
	}
	
	private void addLeaves(World world, Random rand, int dir, BlockPos pos)
	{
		Block b;
		BlockPos pos1;
		if(dir == 0)
		{
			pos1 = pos.add(0, 0, -1);
			b = world.getBlockState(pos1).getBlock();
			if((b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.plants) && rand.nextInt(3) == 0)
			{
				world.setBlockState(pos1, leavesBlock.getStateFromMeta(leavesMeta), 0);
			}
			pos1 = pos.add(0, 0, 1);
			b = world.getBlockState(pos1).getBlock();
			if((b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.plants) && rand.nextInt(3) == 0)
			{
				world.setBlockState(pos1, leavesBlock.getStateFromMeta(leavesMeta), 0);
			}
		}
		else
		{
			pos1 = pos.add(-1, 0, 0);
			b = world.getBlockState(pos1).getBlock();
			if((b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.plants) && rand.nextInt(3) == 0)
			{
				world.setBlockState(pos1, leavesBlock.getStateFromMeta(leavesMeta), 0);
			}
			pos1 = pos.add(1, 0, 0);
			b = world.getBlockState(pos1).getBlock();
			if((b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.plants) && rand.nextInt(3) == 0)
			{
				world.setBlockState(pos1, leavesBlock.getStateFromMeta(leavesMeta), 0);
			}
		}

		pos1 = pos.up();
		b = world.getBlockState(pos).getBlock();
		if((b.getMaterial() == Material.air || b.getMaterial() == Material.vine || b.getMaterial() == Material.plants) && rand.nextInt(3) == 0)
		{
			world.setBlockState(pos, leavesBlock.getStateFromMeta(leavesMeta), 0);
		}
	}
}
