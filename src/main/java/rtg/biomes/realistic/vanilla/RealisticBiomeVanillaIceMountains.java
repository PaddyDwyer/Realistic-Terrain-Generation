package rtg.biomes.realistic.vanilla;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.surface.vanilla.SurfaceVanillaIceMountains;
import rtg.terrain.vanilla.TerrainVanillaIceMountains;

public class RealisticBiomeVanillaIceMountains extends RealisticBiomeVanilla
{	
	public static Block topBlock = BiomeGenBase.iceMountains.topBlock;
	public static Block fillerBlock = BiomeGenBase.iceMountains.fillerBlock;
	
	public RealisticBiomeVanillaIceMountains()
	{
		super(
			BiomeGenBase.iceMountains,
			VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.ICE),
			new TerrainVanillaIceMountains(),
			new SurfaceVanillaIceMountains(topBlock, fillerBlock, Blocks.packed_ice, Blocks.ice)
		);
	}	
}
