package rtg.data;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class VillageMaterialData 
{
	public int biomeID;
	
	public IBlockState logBlock = Blocks.log.getDefaultState();
	public IBlockState cobbleBlock = Blocks.cobblestone.getDefaultState();
	public IBlockState plankBlock = Blocks.planks.getDefaultState();
	public IBlockState pathBlock = Blocks.cobblestone.getDefaultState();
	public IBlockState stairsWoodBlock = Blocks.oak_stairs.getDefaultState();
	public IBlockState stairsStoneBlock = Blocks.stone_stairs.getDefaultState();
	public IBlockState slabsBlock = Blocks.stone_slab.getDefaultState();
	
	public VillageMaterialData(BiomeGenBase biome)
	{	
		biomeID = biome.biomeID;
	}
}
