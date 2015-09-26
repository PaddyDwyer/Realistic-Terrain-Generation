package rtg.biomes.realistic;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.ChunkPrimer;
import rtg.biomes.realistic.desert.RealisticBiomeDesert;
import rtg.biomes.realistic.desert.RealisticBiomeDesertMountains;
import rtg.biomes.realistic.desert.RealisticBiomeDuneValley;
import rtg.biomes.realistic.desert.RealisticBiomeOasis;
import rtg.biomes.realistic.forest.RealisticBiomeDarkRedwood;
import rtg.biomes.realistic.forest.RealisticBiomeDarkRedwoodPlains;
import rtg.biomes.realistic.forest.RealisticBiomeWoodHills;
import rtg.biomes.realistic.forest.RealisticBiomeWoodMountains;
import rtg.biomes.realistic.land.RealisticBiomeHighRainforest;
import rtg.biomes.realistic.land.RealisticBiomeHotRedwood;
import rtg.biomes.realistic.land.RealisticBiomeJungleCanyon;
import rtg.biomes.realistic.land.RealisticBiomeJungleHills;
import rtg.biomes.realistic.land.RealisticBiomePolar;
import rtg.biomes.realistic.land.RealisticBiomeRedwood;
import rtg.biomes.realistic.land.RealisticBiomeRedwoodJungle;
import rtg.biomes.realistic.land.RealisticBiomeRedwoodSnow;
import rtg.biomes.realistic.land.RealisticBiomeSnowHills;
import rtg.biomes.realistic.land.RealisticBiomeSnowLakes;
import rtg.biomes.realistic.land.RealisticBiomeSnowRivers;
import rtg.biomes.realistic.land.RealisticBiomeTaigaHills;
import rtg.biomes.realistic.land.RealisticBiomeTaigaPlains;
import rtg.biomes.realistic.land.RealisticBiomeTest;
import rtg.biomes.realistic.land.RealisticBiomeTestRiver;
import rtg.biomes.realistic.land.RealisticBiomeTundraHills;
import rtg.biomes.realistic.land.RealisticBiomeTundraPlains;
import rtg.biomes.realistic.ocean.RealisticBiomeIslandTropical;
import rtg.biomes.realistic.ocean.RealisticBiomeOceanTest;
import rtg.biomes.realistic.red.RealisticBiomeCanyon;
import rtg.biomes.realistic.red.RealisticBiomeMesa;
import rtg.biomes.realistic.red.RealisticBiomeRedDesertMountains;
import rtg.biomes.realistic.red.RealisticBiomeRedOasis;
import rtg.biomes.realistic.savanna.RealisticBiomeCanyonForest;
import rtg.biomes.realistic.savanna.RealisticBiomeDuneValleyForest;
import rtg.biomes.realistic.savanna.RealisticBiomeHotForest;
import rtg.biomes.realistic.savanna.RealisticBiomeMesaPlains;
import rtg.biomes.realistic.savanna.RealisticBiomeSavanna;
import rtg.biomes.realistic.savanna.RealisticBiomeSavannaDunes;
import rtg.biomes.realistic.savanna.RealisticBiomeSavannaForest;
import rtg.biomes.realistic.savanna.RealisticBiomeStoneMountains;
import rtg.biomes.realistic.savanna.RealisticBiomeStoneMountainsCactus;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaBeach;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaBirchForest;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaBirchForestHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaColdBeach;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaColdTaiga;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaColdTaigaHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaDeepOcean;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaDesert;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaDesertHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaExtremeHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaExtremeHillsPlus;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaForest;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaForestHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaFrozenRiver;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaIceMountains;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaIcePlains;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaJungle;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaJungleEdge;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaJungleHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMegaTaiga;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMegaTaigaHills;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMesa;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMesaPlateau;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMesaPlateauF;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMushroomIsland;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaMushroomIslandShore;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaOcean;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaPlains;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaRiver;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaRoofedForest;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaSavanna;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaSavannaPlateau;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaStoneBeach;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaSwampland;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaTaiga;
import rtg.biomes.realistic.vanilla.RealisticBiomeVanillaTaigaHills;
import rtg.biomes.vanilla.VanillaBiomes;
import rtg.biomes.vanilla.VanillaBiomes.Climate;
import rtg.util.CellNoise;
import rtg.util.PerlinNoise;
import rtg.world.ChunkManagerRealistic;

public class RealisticBiomeBase
{
	private static final RealisticBiomeBase[] biomeList = new RealisticBiomeBase[256];
	private static int nextBiomeID = 0;
	
	public static RealisticBiomeBase test = new RealisticBiomeTest();
	public static RealisticBiomeBase river = new RealisticBiomeTestRiver();
	
	public static RealisticBiomeBase ocean = new RealisticBiomeOceanTest();
	
	//POLAR =========================================================================================
	public static RealisticBiomeBase polar = new RealisticBiomePolar();
	
	//SNOW ==========================================================================================
	public static RealisticBiomeBase snowHills = new RealisticBiomeSnowHills();
	public static RealisticBiomeBase snowRivers = new RealisticBiomeSnowRivers();
	public static RealisticBiomeBase snowLakes = new RealisticBiomeSnowLakes();	
	public static RealisticBiomeBase redwoodSnow = new RealisticBiomeRedwoodSnow();
	
	//PINE ===========================================================================================
	public static RealisticBiomeBase tundraHills = new RealisticBiomeTundraHills();
	public static RealisticBiomeBase tundraPlains = new RealisticBiomeTundraPlains();	
	public static RealisticBiomeBase taigaHills = new RealisticBiomeTaigaHills();
	public static RealisticBiomeBase taigaPlains = new RealisticBiomeTaigaPlains();
	
	//FOREST =========================================================================================
	public static RealisticBiomeBase redwood = new RealisticBiomeRedwood();
	public static RealisticBiomeBase darkRedwood = new RealisticBiomeDarkRedwood();
	public static RealisticBiomeBase darkRedwoodPlains = new RealisticBiomeDarkRedwoodPlains();
	public static RealisticBiomeBase woodhills = new RealisticBiomeWoodHills();
	public static RealisticBiomeBase woodmountains = new RealisticBiomeWoodMountains();
	
	//SAVANNA ========================================================================================
	public static RealisticBiomeBase duneValleyForest = new RealisticBiomeDuneValleyForest();	
	public static RealisticBiomeBase savanna = new RealisticBiomeSavanna();
	public static RealisticBiomeBase savannaForest = new RealisticBiomeSavannaForest();
	public static RealisticBiomeBase savannaDunes = new RealisticBiomeSavannaDunes();
	public static RealisticBiomeBase stoneMountains = new RealisticBiomeStoneMountains();
	public static RealisticBiomeBase stoneMountainsCactus = new RealisticBiomeStoneMountainsCactus();
	public static RealisticBiomeBase hotForest = new RealisticBiomeHotForest();
	public static RealisticBiomeBase hotRedwood = new RealisticBiomeHotRedwood();
	public static RealisticBiomeBase canyonForest = new RealisticBiomeCanyonForest();
	public static RealisticBiomeBase mesaPlains = new RealisticBiomeMesaPlains();
	
	//DESERT =========================================================================================
	public static RealisticBiomeBase desert = new RealisticBiomeDesert();
	public static RealisticBiomeBase desertMountains = new RealisticBiomeDesertMountains();
	public static RealisticBiomeBase duneValley = new RealisticBiomeDuneValley();	
	public static RealisticBiomeBase oasis = new RealisticBiomeOasis();
	
	//RED ============================================================================================
	public static RealisticBiomeBase redDesertMountains = new RealisticBiomeRedDesertMountains();
	public static RealisticBiomeBase redDesertOasis = new RealisticBiomeRedOasis();
	public static RealisticBiomeBase canyon = new RealisticBiomeCanyon();
	public static RealisticBiomeBase mesa = new RealisticBiomeMesa();
	
	//SWAMP ==========================================================================================
	
	//TROPICAL =======================================================================================
	
	//JUNGLE =========================================================================================
	public static RealisticBiomeBase rainForestHigh = new RealisticBiomeHighRainforest();
	public static RealisticBiomeBase jungleHills = new RealisticBiomeJungleHills();
	public static RealisticBiomeBase jungleCanyon = new RealisticBiomeJungleCanyon();
	public static RealisticBiomeBase redwoodJungle = new RealisticBiomeRedwoodJungle(); 
	
	//OCEAN =========================================================================================
	public static RealisticBiomeBase islandTropical = new RealisticBiomeIslandTropical();
	
	
	//VANILLA =======================================================================================
	public static RealisticBiomeBase vanillaBeach = new RealisticBiomeVanillaBeach();
	public static RealisticBiomeBase vanillaBirchForest = new RealisticBiomeVanillaBirchForest();
	public static RealisticBiomeBase vanillaBirchForestHills = new RealisticBiomeVanillaBirchForestHills();
	public static RealisticBiomeBase vanillaColdBeach = new RealisticBiomeVanillaColdBeach();
	public static RealisticBiomeBase vanillaColdTaiga = new RealisticBiomeVanillaColdTaiga();
	public static RealisticBiomeBase vanillaColdTaigaHills = new RealisticBiomeVanillaColdTaigaHills();
	public static RealisticBiomeBase vanillaDeepOcean = new RealisticBiomeVanillaDeepOcean();
	public static RealisticBiomeBase vanillaDesert = new RealisticBiomeVanillaDesert();
	public static RealisticBiomeBase vanillaDesertHills = new RealisticBiomeVanillaDesertHills();
	public static RealisticBiomeBase vanillaExtremeHills = new RealisticBiomeVanillaExtremeHills();
	public static RealisticBiomeBase vanillaExtremeHillsPlus = new RealisticBiomeVanillaExtremeHillsPlus();
	public static RealisticBiomeBase vanillaForest = new RealisticBiomeVanillaForest();
	public static RealisticBiomeBase vanillaForestHills = new RealisticBiomeVanillaForestHills();
	public static RealisticBiomeBase vanillaFrozenRiver = new RealisticBiomeVanillaFrozenRiver();
	public static RealisticBiomeBase vanillaIcePlains = new RealisticBiomeVanillaIcePlains();
	public static RealisticBiomeBase vanillaIceMountains = new RealisticBiomeVanillaIceMountains();
	public static RealisticBiomeBase vanillaJungle = new RealisticBiomeVanillaJungle();
	public static RealisticBiomeBase vanillaJungleEdge = new RealisticBiomeVanillaJungleEdge();
	public static RealisticBiomeBase vanillaJungleHills = new RealisticBiomeVanillaJungleHills();
	public static RealisticBiomeBase vanillaMegaTaiga = new RealisticBiomeVanillaMegaTaiga();
	public static RealisticBiomeBase vanillaMegaTaigaHills = new RealisticBiomeVanillaMegaTaigaHills();
	public static RealisticBiomeBase vanillaMesa = new RealisticBiomeVanillaMesa();
	public static RealisticBiomeBase vanillaMesaPlateau = new RealisticBiomeVanillaMesaPlateau();
	public static RealisticBiomeBase vanillaMesaPlateau_F = new RealisticBiomeVanillaMesaPlateauF();
	public static RealisticBiomeBase vanillaMushroomIsland = new RealisticBiomeVanillaMushroomIsland();
	public static RealisticBiomeBase vanillaMushroomIslandShore = new RealisticBiomeVanillaMushroomIslandShore();
	public static RealisticBiomeBase vanillaOcean = new RealisticBiomeVanillaOcean();
	public static RealisticBiomeBase vanillaPlains = new RealisticBiomeVanillaPlains();
	public static RealisticBiomeBase vanillaRiver = new RealisticBiomeVanillaRiver();
	public static RealisticBiomeBase vanillaRoofedForest = new RealisticBiomeVanillaRoofedForest();
	public static RealisticBiomeBase vanillaSavanna = new RealisticBiomeVanillaSavanna();
	public static RealisticBiomeBase vanillaSavannaPlateau = new RealisticBiomeVanillaSavannaPlateau();
	public static RealisticBiomeBase vanillaStoneBeach = new RealisticBiomeVanillaStoneBeach();
	public static RealisticBiomeBase vanillaSwampland = new RealisticBiomeVanillaSwampland();
	public static RealisticBiomeBase vanillaTaiga = new RealisticBiomeVanillaTaiga();
	public static RealisticBiomeBase vanillaTaigaHills = new RealisticBiomeVanillaTaigaHills();
	
	// ==============================================================================================
	
	public final int biomeID;
	public final int subID;
	public final BiomeGenBase baseBiome;
	public final BiomeGenBase riverBiome;
	
	public RealisticBiomeBase(int sub, BiomeGenBase biome)
	{
		this(sub, biome, VanillaBiomes.climatizedBiome(BiomeGenBase.river, Climate.TEMPERATE));
	}
	
	public RealisticBiomeBase(int sub, BiomeGenBase biome, BiomeGenBase river)
	{
		biomeID = nextBiomeID;
		biomeList[biomeID] = this;
		nextBiomeID++;
		
		subID = sub;
		baseBiome = biome;
		riverBiome = river;
	}
	
	public static RealisticBiomeBase getBiome(int id)
	{
		return biomeList[id];
	}
	
	
	//======================================================================================================================================
	
	
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
    {
    }
    
    public void generateMapGen(ChunkPrimer chunkPrimer, Long seed, World world, ChunkManagerRealistic cmr, Random mapRand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float noise[])
    {
        int k = 5;
        mapRand.setSeed(seed);
        long l = (mapRand.nextLong() / 2L) * 2L + 1L;
        long l1 = (mapRand.nextLong() / 2L) * 2L + 1L;
        for(int baseX = chunkX - k; baseX <= chunkX + k; baseX++)
        {
            for(int baseY = chunkY - k; baseY <= chunkY + k; baseY++)
            {
            	mapRand.setSeed((long)baseX * l + (long)baseY * l1 ^ seed);
                rMapGen(chunkPrimer, world, cmr, mapRand, baseX, baseY, chunkX, chunkY, perlin, cell, noise);
            }
        }
    }
    
    public void rMapGen(ChunkPrimer chunkPrimer, World world, ChunkManagerRealistic cmr, Random mapRand, int chunkX, int chunkY, int baseX, int baseY, PerlinNoise perlin, CellNoise cell, float noise[])
    {
    }
    
    public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
    {
    	return 63f;
    }
    
    public void rReplace(ChunkPrimer chunkPrimer, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
    {
    	Block b;
		for(int k = 255; k > -1; k--)
		{
			b = chunkPrimer.getBlockState((y * 16 + x) * 256 + k).getBlock();
            if(b == Blocks.air)
            {
            	depth = -1;
            }
            else if(b == Blocks.stone)
            {
            	depth++;

        		if(depth == 0)
        		{
    				if(k < 62)
    				{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
    				}
    				else
    				{
    					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.grass.getDefaultState());
    				}
        		}
        		else if(depth < 6)
        		{
					chunkPrimer.setBlockState((y * 16 + x) * 256 + k, Blocks.dirt.getDefaultState());
        		}
            }
		}
    }
    
    public float r3Dnoise(float z)
    {
    	return 0f;
    }
}
