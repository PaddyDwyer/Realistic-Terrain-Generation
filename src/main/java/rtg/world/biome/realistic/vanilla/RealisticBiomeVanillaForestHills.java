package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaForest;
import rtg.world.gen.surface.vanilla.SurfaceVanillaForestHills;
import rtg.world.gen.terrain.vanilla.TerrainVanillaForest;
import rtg.world.gen.terrain.vanilla.TerrainVanillaForestHills;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaForestHills;
import rtg.terrain.vanilla.TerrainVanillaForestHills;

public class RealisticBiomeVanillaForestHills extends RealisticBiomeVanillaBase
{	
	public static IBlockState topBlock = BiomeGenBase.forestHills.topBlock;
	public static IBlockState fillerBlock = BiomeGenBase.forestHills.fillerBlock;
	
	public RealisticBiomeVanillaForestHills()
	{
		super(
			BiomeGenBase.forestHills,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.TEMPERATE),
			new TerrainVanillaForestHills(70f, 180f, 7f, 100f, 38f, 260f, 68f),
			new SurfaceVanillaForestHills(topBlock, fillerBlock, topBlock, topBlock)
		);
	}	
}
