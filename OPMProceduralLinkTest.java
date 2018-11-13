/**
 */
package opm.tests;

import junit.textui.TestRunner;

import opm.OPMProceduralLink;
import opm.OpmFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>OPM Procedural Link</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class OPMProceduralLinkTest extends OPMLinkTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(OPMProceduralLinkTest.class);
	}

	/**
	 * Constructs a new OPM Procedural Link test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OPMProceduralLinkTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this OPM Procedural Link test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected OPMProceduralLink getFixture() {
		return (OPMProceduralLink)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OpmFactory.eINSTANCE.createOPMProceduralLink());
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

} //OPMProceduralLinkTest
