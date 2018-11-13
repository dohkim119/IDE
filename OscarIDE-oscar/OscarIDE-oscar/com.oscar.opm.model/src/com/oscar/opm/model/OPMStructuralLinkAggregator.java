/**
 */
package com.oscar.opm.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structural Link Aggregator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.oscar.opm.model.OPMStructuralLinkAggregator#getKind <em>Kind</em>}</li>
 * </ul>
 *
 * @see com.oscar.opm.model.OPMPackage#getOPMStructuralLinkAggregator()
 * @model
 * @generated
 */
public interface OPMStructuralLinkAggregator extends OPMNode {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link com.oscar.opm.model.OPMStructuralLinkAggregatorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see com.oscar.opm.model.OPMStructuralLinkAggregatorKind
	 * @see #setKind(OPMStructuralLinkAggregatorKind)
	 * @see com.oscar.opm.model.OPMPackage#getOPMStructuralLinkAggregator_Kind()
	 * @model
	 * @generated
	 */
	OPMStructuralLinkAggregatorKind getKind();

	/**
	 * Sets the value of the '{@link com.oscar.opm.model.OPMStructuralLinkAggregator#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see com.oscar.opm.model.OPMStructuralLinkAggregatorKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(OPMStructuralLinkAggregatorKind value);

} // OPMStructuralLinkAggregator
