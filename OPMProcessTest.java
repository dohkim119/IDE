/**
 */
package opm.tests;

import junit.textui.TestRunner;

import opm.OPMProcess;
import opm.OpmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>OPM Process</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMProcessTest extends OPMThingTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OPMProcessTest.class);
	}

	/**
	 * Constructs a new OPM Process test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMProcessTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this OPM Process test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OPMProcess getFixture() {
		return (OPMProcess)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OpmFactory.eINSTANCE.createOPMProcess());
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

} //OPMProcessTest
