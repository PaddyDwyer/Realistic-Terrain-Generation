package rtg.data;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rtg.RTG;
import rtg.deco.trees.DecoSavannah;
import rtg.deco.trees.DecoSmallPine;

public class TreeReplacement 
{
	/*
	 * 
	 * 
	 * 
	 * Missing a check for air and its extremely buggy :(
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	@SubscribeEvent
	public boolean saplingGrowTree(SaplingGrowTreeEvent e) 
	{
		System.out.println("Zwieber nie gaan stele nu he");
		if(e.world.getWorldInfo().getTerrainType() == RTG.worldtype)
		{
			BlockPlanks.EnumType type = (EnumType) e.world.getBlockState(e.pos).getValue(BlockSapling.TYPE);
			System.out.println("tiepe: " + type);
			if(type == BlockPlanks.EnumType.SPRUCE)
			{
				e.world.setBlockState(e.pos, Blocks.air.getDefaultState());
				(new DecoSmallPine(3 + e.rand.nextInt(3), 5 + e.rand.nextInt(5))).generate(e.world, e.rand, e.pos);
				return true;
			}			
			if(type == BlockPlanks.EnumType.ACACIA)
			{
				e.world.setBlockState(e.pos, Blocks.air.getDefaultState());
				(new DecoSavannah(1)).generate(e.world, e.rand, e.pos);
				return true;
			}
		}
		return false;
	}
}
