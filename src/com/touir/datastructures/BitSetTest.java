package com.touir.datastructures;

import java.util.BitSet;

public class BitSetTest {

	public static void main(String[] args) {

		// different construction methods
		BitSet bitSet = new BitSet();
		BitSet bitSet2 = new BitSet(100_100);
		BitSet bitSet3 = BitSet.valueOf(new long[] { 42, 12 });
		
		String bitRepresentation = "";
		for(int i=0;i<bitSet3.size();i++) {
			bitRepresentation = bitRepresentation + (bitSet3.get(i)?"1" : "0");
			System.out.println("bit "+i+": "+ bitSet3.get(i));
		}
		System.out.println(bitRepresentation);
		
		bitSet = new BitSet(1024);
		bitSet.set(5,10);
		System.out.println("size: " + bitSet.size() + ", length: " + bitSet.length() 
	       + ", cardinality: " + bitSet.cardinality() + ", isEmpty: " + bitSet.isEmpty());
		bitSet.clear();
		System.out.println("size: " + bitSet.size() + ", length: " + bitSet.length() 
	       + ", cardinality: " + bitSet.cardinality() + ", isEmpty: " + bitSet.isEmpty());

		BitSet b1 = BitSet.valueOf(new long[]{6});  // 00110
		BitSet b2 = BitSet.valueOf(new long[]{10}); // 01010
		
		// and operation between 2 bitSets, the result is put in the first variable (the one calling and())
		b1.and(b2); // b1 = 010 (2)
		System.out.println(b1);
		
		// andNot clears all the bits that are set to true in the corresponding bitSet passed as parameter
		// x.andNot(y) is equivalent to x & (~ y) which is equivalent to x and (not y) in logical terms.
		b1 = BitSet.valueOf(new long[]{6});
		b1.andNot(b2); // result: b1 = 00100
		System.out.println(b1);
		
		// or operation between 2 bitSets, result is in the first variable
		b1.or(b2); // result: b1 = 00100 & 01010 = 01110
		System.out.println(b1);
		
		// xor operation
		b1.xor(b2); // b1 = 01110 ^ 01010 = 00100
		System.out.println(b1);
		
		// intersects operation returns true if both BitSets have at least 1 bit set to true at the same position.
		System.out.println(b1.intersects(b2)); // false
		b1 = BitSet.valueOf(new long[]{2});
		System.out.println(b1.intersects(b2)); // true
		
		bitSet = BitSet.valueOf(new long[]{22}); // 010110

		// next set bit (fromInclusive)
		System.out.println(bitSet.nextSetBit(1)); // 1
		System.out.println(bitSet.nextSetBit(3)); // 4

		// next unset bit (fromInclusive)
		System.out.println(bitSet.nextClearBit(1)); // 3

		// previous set bit (fromInclusive)
		System.out.println(bitSet.previousSetBit(3)); // 2

		// previous unset bit (fromInclusive)
		System.out.println(bitSet.previousClearBit(2)); // 0
		
		
	}//101010 = 2 + 8 + 32 = 42

}
