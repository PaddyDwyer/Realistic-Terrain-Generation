package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaSavannaPlateau;
import rtg.terrain.vanilla.TerrainVanillaSavannaPlateau;

public class RealisticBiomeVanillaSavannaPlateau extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.savannaPlateau.topBlock;
	public static Block fillerBlock = BiomeGenBase.savannaPlateau.fillerBlock;
	
	public RealisticBiomeVanillaSavannaPlateau()
	{
		super(
			BiomeGenBase.savannaPlateau,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.HOT),
			new TerrainVanillaSavannaPlateau(0f, 120f, 68f, 200f),
			new SurfaceVanillaSavannaPlateau(topBlock, fillerBlock, 300f, true, true)
		);
	}	
}
