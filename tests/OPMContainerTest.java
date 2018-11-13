/**
 */
package opm.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import opm.OPMContainer;
import opm.OpmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>OPM Container</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMContainerTest extends TestCase {

	/**
	 * The fixture for this OPM Container test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMContainer fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OPMContainerTest.class);
	}

	/**
	 * Constructs a new OPM Container test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMContainerTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this OPM Container test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(OPMContainer fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this OPM Container test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OPMContainer getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OpmFactory.eINSTANCE.createOPMContainer());
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

} //OPMContainerTest
