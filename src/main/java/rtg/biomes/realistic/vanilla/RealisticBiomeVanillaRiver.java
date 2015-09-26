package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaRiver;
import rtg.terrain.vanilla.TerrainVanillaRiver;

public class RealisticBiomeVanillaRiver extends RealisticBiomeVanilla
{	
	public static BiomeGenBase vanillaBiome = BiomeGenBase.river;
	public static Block topBlock = vanillaBiome.topBlock;
	public static Block fillerBlock = vanillaBiome.fillerBlock;
	
	public RealisticBiomeVanillaRiver()
	{
		super(
			vanillaBiome,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaRiver(),
			new SurfaceVanillaRiver(Blocks.sand, Blocks.sand, Blocks.grass, Blocks.grass, (byte)0, 0)
		);
	}	
}
