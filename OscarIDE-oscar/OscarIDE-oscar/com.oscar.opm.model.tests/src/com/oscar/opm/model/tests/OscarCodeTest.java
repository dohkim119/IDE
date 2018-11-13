/**
 */
package com.oscar.opm.model.tests;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OscarCode;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Oscar Code</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OscarCodeTest extends OPMObjectTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OscarCodeTest.class);
	}

	/**
	 * Constructs a new Oscar Code test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OscarCodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Oscar Code test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OscarCode getFixture() {
		return (OscarCode)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OPMFactory.eINSTANCE.createOscarCode());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //OscarCodeTest
