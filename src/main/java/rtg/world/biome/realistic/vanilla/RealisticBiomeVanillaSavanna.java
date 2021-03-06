package rtg.world.biome.realistic.vanilla;

import rtg.world.biome.BiomeBase;
import rtg.world.biome.BiomeBase.Climate;
import rtg.world.biome.realistic.RealisticBiomeBase;
import rtg.world.gen.surface.vanilla.SurfaceVanillaSavanna;
import rtg.world.gen.terrain.vanilla.TerrainVanillaSavanna;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class RealisticBiomeVanillaSavanna extends RealisticBiomeVanillaBase
{	
	public static Block topBlock = BiomeGenBase.savanna.topBlock;
	public static Block fillerBlock = BiomeGenBase.savanna.fillerBlock;
	
	public RealisticBiomeVanillaSavanna()
	{
		super(
			BiomeGenBase.savanna,
			BiomeBase.climatizedBiome(BiomeGenBase.river, BiomeBase.Climate.HOT),
			new TerrainVanillaSavanna(),
			new SurfaceVanillaSavanna(topBlock, fillerBlock, Blocks.stone, Blocks.cobblestone)
		);
	}	
}
