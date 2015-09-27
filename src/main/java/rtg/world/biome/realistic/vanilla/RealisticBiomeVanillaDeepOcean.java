package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaDeepOcean;
import rtg.world.gen.terrain.vanilla.TerrainVanillaDeepOcean;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaDeepOcean;
import rtg.terrain.vanilla.TerrainVanillaDeepOcean;

public class RealisticBiomeVanillaDeepOcean extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.deepOcean.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.deepOcean.fillerBlock;
	
	public RealisticBiomeVanillaDeepOcean()
	{
		super(
			BiomeGenBase.deepOcean,
			BiomeBase.climatizedBiome(BiomeGenBase.ocean, BiomeBase.Climate.TEMPERATE),
			new TerrainVanillaDeepOcean(),
			new SurfaceVanillaDeepOcean(Blocks.sand.getDefaultState(), Blocks.sand.getDefaultState(), 0)
		);
	}	
}
