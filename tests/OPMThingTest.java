/**
 */
package opm.tests;

import junit.textui.TestRunner;

import opm.OPMThing;
import opm.OpmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>OPM Thing</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMThingTest extends OPMNodeTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OPMThingTest.class);
	}

	/**
	 * Constructs a new OPM Thing test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMThingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this OPM Thing test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OPMThing getFixture() {
		return (OPMThing)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OpmFactory.eINSTANCE.createOPMThing());
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

} //OPMThingTest
