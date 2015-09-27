package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaOcean;
import rtg.world.gen.terrain.vanilla.TerrainVanillaOcean;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class RealisticBiomeVanillaOcean extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.ocean.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.ocean.fillerBlock;
	
	public RealisticBiomeVanillaOcean()
	{
		super(
			BiomeGenBase.ocean,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.TEMPERATE),
			new TerrainVanillaOcean(),
			new SurfaceVanillaOcean(Blocks.sand.getDefaultState(), Blocks.sand.getDefaultState(), 0)
		);
	}	
}
