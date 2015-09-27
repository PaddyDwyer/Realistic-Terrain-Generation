package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaDesertHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaDesertHills;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaDesertHills;
import rtg.terrain.vanilla.TerrainVanillaDesertHills;

public class RealisticBiomeVanillaDesertHills extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.desertHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.desertHills.fillerBlock;
	
	public RealisticBiomeVanillaDesertHills()
	{
		super(
			BiomeGenBase.desertHills,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.OASIS),
			new TerrainVanillaDesertHills(230f, 120f, 0f),
			new SurfaceVanillaDesertHills(topBlock, fillerBlock, Blocks.sandstone.getDefaultState(), topBlock, fillerBlock)
		);
	}	
}
