package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaForest;
import rtg.world.gen.terrain.vanilla.TerrainVanillaForest;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaForest extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.forest.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.forest.fillerBlock;
	
	public RealisticBiomeVanillaForest()
	{
		super(
			BiomeGenBase.forest,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.TEMPERATE),
			new TerrainVanillaForest(),
			new SurfaceVanillaForest(topBlock, fillerBlock, Blocks.stone.getDefaultState(), Blocks.cobblestone.getDefaultState())
		);
	}	
}
