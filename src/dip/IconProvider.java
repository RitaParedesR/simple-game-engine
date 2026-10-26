package dip;

import javax.swing.Icon;

/** Reemplaza las rutas fijas "src\\icons\\circle.png" (D3). */
public interface IconProvider { Icon load(String name); }
