/**
 */
package com.oscar.opm.model.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>opm</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new OPMTests("opm Tests");
		suite.addTestSuite(OPMNodeTest.class);
		suite.addTestSuite(OPMThingTest.class);
		suite.addTestSuite(OPMObjectTest.class);
		suite.addTestSuite(OPMProcessTest.class);
		suite.addTestSuite(OPMStructuralLinkAggregatorTest.class);
		suite.addTestSuite(OscarCodeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMTests(String name) {
		super(name);
	}

} //OPMTests
