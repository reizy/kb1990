package ru.reizy.kb1990.model.globalmap;

import java.util.HashSet;
import java.util.Set;

public enum FieldType {
	HILL_ILB, SAND_ILB, BUSH_ILB, POOL_ILB, //
	HILL_IRB, SAND_IRB, BUSH_IRB, POOL_IRB, //
	HILL_ILT, SAND_ILT, BUSH_ILT, POOL_ILT, //
	HILL_IRT, SAND_IRT, BUSH_IRT, POOL_IRT, //
	HILL_OLB, SAND_OLB, BUSH_OLB, POOL_OLB, //
	HILL_ORB, SAND_ORB, BUSH_ORB, POOL_ORB, //
	HILL_OLT, SAND_OLT, BUSH_OLT, POOL_OLT, //
	HILL_ORT, SAND_ORT, BUSH_ORT, POOL_ORT, //
	HILL_L, SAND_L, BUSH_L, POOL_L, //
	HILL_R, SAND_R, BUSH_R, POOL_R, //
	HILL_T, SAND_T, BUSH_T, POOL_T, //
	HILL_B, SAND_B, BUSH_B, POOL_B, //
	HILL_I, SAND_I, BUSH_I, POOL_I, //
	HILL_O, SAND_O, BUSH_O, POOL_O, //

	CASTLE_TL, CASTLE_T, CASTLE_TR, CASTLE_BL, CASTLE_B, CASTLE_BR, CASTLE_S, //

	GRASS, TOWN, SIGNPOST, //
	BONUS, ENEMY, MAGE, HERO, //

	SHIP, PLAYER;

	public static final Set<FieldType> ACTIVE = new HashSet<FieldType>(5);
	public static final Set<FieldType> POOLS = new HashSet<FieldType>(15);
	public static final Set<FieldType> SANDS = new HashSet<FieldType>(15);
	public static final Set<FieldType> BUSHES = new HashSet<FieldType>(15);
	public static final Set<FieldType> HILLS = new HashSet<FieldType>(15);
	public static final Set<FieldType> CASTLES = new HashSet<FieldType>(15);
	public static final Set<FieldType> MOVABLE = new HashSet<FieldType>(15);

	static {
		{
			ACTIVE.add(BONUS);
			ACTIVE.add(ENEMY);
			ACTIVE.add(MAGE);
			ACTIVE.add(CASTLE_B);
			ACTIVE.add(TOWN);
			ACTIVE.add(SIGNPOST);
			ACTIVE.add(PLAYER);
			ACTIVE.add(SHIP);
		}
		{
			POOLS.add(POOL_ILB);
			POOLS.add(POOL_IRB);
			POOLS.add(POOL_ILT);
			POOLS.add(POOL_IRT);
			POOLS.add(POOL_OLB);
			POOLS.add(POOL_ORB);
			POOLS.add(POOL_OLT);
			POOLS.add(POOL_ORT);
			POOLS.add(POOL_L);
			POOLS.add(POOL_R);
			POOLS.add(POOL_T);
			POOLS.add(POOL_B);
			POOLS.add(POOL_I);
			POOLS.add(POOL_O);
		}
		{
			SANDS.add(SAND_ILB);
			SANDS.add(SAND_IRB);
			SANDS.add(SAND_ILT);
			SANDS.add(SAND_IRT);
			SANDS.add(SAND_OLB);
			SANDS.add(SAND_ORB);
			SANDS.add(SAND_OLT);
			SANDS.add(SAND_ORT);
			SANDS.add(SAND_L);
			SANDS.add(SAND_R);
			SANDS.add(SAND_T);
			SANDS.add(SAND_B);
			SANDS.add(SAND_I);
			SANDS.add(SAND_O);
		}
		{
			BUSHES.add(BUSH_ILB);
			BUSHES.add(BUSH_IRB);
			BUSHES.add(BUSH_ILT);
			BUSHES.add(BUSH_IRT);
			BUSHES.add(BUSH_OLB);
			BUSHES.add(BUSH_ORB);
			BUSHES.add(BUSH_OLT);
			BUSHES.add(BUSH_ORT);
			BUSHES.add(BUSH_L);
			BUSHES.add(BUSH_R);
			BUSHES.add(BUSH_T);
			BUSHES.add(BUSH_B);
			BUSHES.add(BUSH_I);
			BUSHES.add(BUSH_O);
		}
		{
			HILLS.add(HILL_ILB);
			HILLS.add(HILL_IRB);
			HILLS.add(HILL_ILT);
			HILLS.add(HILL_IRT);
			HILLS.add(HILL_OLB);
			HILLS.add(HILL_ORB);
			HILLS.add(HILL_OLT);
			HILLS.add(HILL_ORT);
			HILLS.add(HILL_L);
			HILLS.add(HILL_R);
			HILLS.add(HILL_T);
			HILLS.add(HILL_B);
			HILLS.add(HILL_I);
			HILLS.add(HILL_O);
		}
		{
			CASTLES.add(CASTLE_TL);
			CASTLES.add(CASTLE_T);
			CASTLES.add(CASTLE_TR);
			CASTLES.add(CASTLE_BL);
			CASTLES.add(CASTLE_B);
			CASTLES.add(CASTLE_BR);
			CASTLES.add(CASTLE_S);
		}
		{
			MOVABLE.addAll(SANDS);
			MOVABLE.add(GRASS);
			MOVABLE.add(ENEMY);
			MOVABLE.add(HERO);
			MOVABLE.add(SIGNPOST);
		}
	}

}
