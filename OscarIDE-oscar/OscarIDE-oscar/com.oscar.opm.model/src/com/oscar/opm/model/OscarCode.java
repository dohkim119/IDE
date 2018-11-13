/**
 */
package com.oscar.opm.model;

import java.io.File;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Oscar Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.oscar.opm.model.OscarCode#getCodefile <em>Codefile</em>}</li>
 * </ul>
 *
 * @see com.oscar.opm.model.OPMPackage#getOscarCode()
 * @model
 * @generated
 */
public interface OscarCode extends OPMObject {
	/**
	 * Returns the value of the '<em><b>Codefile</b></em>' attribute.
	 * The default value is <code>".default.txt"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Codefile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codefile</em>' attribute.
	 * @see #setCodefile(File)
	 * @see com.oscar.opm.model.OPMPackage#getOscarCode_Codefile()
	 * @model default=".default.txt" dataType="com.oscar.opm.model.File"
	 * @generated
	 */
	File getCodefile();

	/**
	 * Sets the value of the '{@link com.oscar.opm.model.OscarCode#getCodefile <em>Codefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codefile</em>' attribute.
	 * @see #getCodefile()
	 * @generated
	 */
	void setCodefile(File value);

} // OscarCode
