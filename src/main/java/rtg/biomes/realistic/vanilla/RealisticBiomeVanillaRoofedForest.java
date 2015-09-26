package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaRoofedForest;
import rtg.terrain.vanilla.TerrainVanillaRoofedForest;

public class RealisticBiomeVanillaRoofedForest extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.roofedForest.topBlock;
	public static Block fillerBlock = BiomeGenBase.roofedForest.fillerBlock;
	
	public RealisticBiomeVanillaRoofedForest()
	{
		super(
			BiomeGenBase.roofedForest,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaRoofedForest(),
			new SurfaceVanillaRoofedForest(topBlock, fillerBlock, Blocks.stone, Blocks.cobblestone)
		);
	}	
}
