/**
 */
package com.oscar.opm.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.oscar.opm.model.OPMContainer#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see com.oscar.opm.model.OPMPackage#getOPMContainer()
 * @model
 * @generated
 */
public interface OPMContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link com.oscar.opm.model.OPMNode}.
	 * It is bidirectional and its opposite is '{@link com.oscar.opm.model.OPMNode#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see com.oscar.opm.model.OPMPackage#getOPMContainer_Nodes()
	 * @see com.oscar.opm.model.OPMNode#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<OPMNode> getNodes();

} // OPMContainer
