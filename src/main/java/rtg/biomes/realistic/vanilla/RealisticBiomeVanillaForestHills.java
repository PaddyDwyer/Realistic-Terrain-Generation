package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaForestHills;
import rtg.terrain.vanilla.TerrainVanillaForestHills;

public class RealisticBiomeVanillaForestHills extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.forestHills.topBlock;
	public static Block fillerBlock = BiomeGenBase.forestHills.fillerBlock;
	
	public RealisticBiomeVanillaForestHills()
	{
		super(
			BiomeGenBase.forestHills,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE),
			new TerrainVanillaForestHills(70f, 180f, 7f, 100f, 38f, 260f, 68f),
			new SurfaceVanillaForestHills(topBlock, fillerBlock, topBlock, topBlock)
		);
	}	
}
