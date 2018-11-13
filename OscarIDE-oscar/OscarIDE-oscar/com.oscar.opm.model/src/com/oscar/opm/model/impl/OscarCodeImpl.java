/**
 */
package com.oscar.opm.model.impl;

import com.oscar.opm.model.OPMFactory;
import com.oscar.opm.model.OPMPackage;
import com.oscar.opm.model.OscarCode;

import java.io.File;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Oscar Code</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.oscar.opm.model.impl.OscarCodeImpl#getCodefile <em>Codefile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OscarCodeImpl extends OPMObjectImpl implements OscarCode {
	/**
	 * The default value of the '{@link #getCodefile() <em>Codefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodefile()
	 * @generated
	 * @ordered
	 */
	protected static final File CODEFILE_EDEFAULT = (File)OPMFactory.eINSTANCE.createFromString(OPMPackage.eINSTANCE.getFile(), ".default.txt");

	/**
	 * The cached value of the '{@link #getCodefile() <em>Codefile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodefile()
	 * @generated
	 * @ordered
	 */
	protected File codefile = CODEFILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OscarCodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OPMPackage.Literals.OSCAR_CODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File getCodefile() {
		return codefile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodefile(File newCodefile) {
		File oldCodefile = codefile;
		codefile = newCodefile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OPMPackage.OSCAR_CODE__CODEFILE, oldCodefile, codefile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OPMPackage.OSCAR_CODE__CODEFILE:
				return getCodefile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OPMPackage.OSCAR_CODE__CODEFILE:
				setCodefile((File)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OPMPackage.OSCAR_CODE__CODEFILE:
				setCodefile(CODEFILE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OPMPackage.OSCAR_CODE__CODEFILE:
				return CODEFILE_EDEFAULT == null ? codefile != null : !CODEFILE_EDEFAULT.equals(codefile);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (codefile: ");
		result.append(codefile);
		result.append(')');
		return result.toString();
	}

} //OscarCodeImpl
