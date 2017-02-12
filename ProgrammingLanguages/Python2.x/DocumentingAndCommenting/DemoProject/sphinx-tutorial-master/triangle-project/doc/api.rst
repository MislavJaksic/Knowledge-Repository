The triangllib API Reference
============================

Tutorial: This is how you write documentation manually. Don't do it. Use autodoc to generate docs from docstrings.

.. automodule:: trianglelib
   :members:

Tutorial: The above is generated using autodoc and extracted from __init__.py

1. The "shape" module
---------------------

.. module:: trianglelib.shape

Tutorial: This is how you lock a piece of code in a rectangle::
   
   from trianglelib.shape import Triangle
   t = Triangle(3, 4, 5)
   print t.is_equilateral()
   print t.area()
   
.. autoclass:: Triangle
   :members:

Tutorial: The above is generated using autodoc and extracted from docstrings in shape.py

2. The "utils" module
---------------------

.. automodule:: trianglelib.utils
   :members:

Tutorial: The above is generated using autodoc and extracted from docstrings in utils.py