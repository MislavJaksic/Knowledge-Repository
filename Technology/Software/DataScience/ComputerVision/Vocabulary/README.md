Affine normalisation of the ellipse - ?? (SURF ref 31)  
Affine transformations - those which will keep parallel lines parallel even after transformation; translating (moving in a direction), scaling (multiplying by a factor), rotating (which includes reflection), shearing (squashing the object, making a square into a romb)  
Aliasing - if a continuous signal has been sampled with a frequency smaller then twice the highest signal frequency, it is impossible to reconstruct the original signal based solely on the sparse samples, that is, we can reconstruct many signals with different frequencies instead of only the original signal  
Blob structures - also known as blobs are areas in the image that differ from the surrounding area  
Box filter - also known as convolution matrix  
Boxlets - ??  
Convolution filter/mask/kernel/matrix - a matrix that assignes a value to a pixel in a new (blank) image based on the dot product of the pixels in the original image and the matrix  
Decimation - also known as downsampling; changes the resolution of the image  
Descriptor - an algorithm that describes the area around the interest points, however it is also used to describe the feature vector which describes the area around the interest point  
Detector - also known as feature detector, is an algorithm that tries to find interest points in the picture  
Determinant - can be calculated using the Laplace formula (expansion); wikipedia has a nice example  
Difference of Gaussian (DoG) - subtracting two differently blurred images to produce a third image in which only a few spatial frequencies are preserved  
Eigenvector, eigenvalues - if there exist vectors V and W and matrix A and scalar multiple m such that vectors V and W are scalar multiples of each other (A*V = W and A*V = m*V) then V is an eigenvector and m eigenvalue  
Feature vector - also known as the descriptor, imagine it as a point is N dimensional space where N is the number of features  
Frobenius norm - square root of all absolute values squared in the matrix  
Gradient - the change of the intensity, geometrically interpreted as a pointer in the direction of the greatest change  
Harris detector - also known as Harris corner detector is a function E(u,v) which calculates the change of intensities in two directions; if the intensity changes in only one direction, it's an edge and if the intensity doesn't change at all, we are looking at a flat featureless area  
Hessian detector - ?? (wave your hand and say its like the Harris one)  
Hessian matrix - a square matrix which holds second partial derivatives of every combination of variables; use Schwarz's theorem  
Image pyramid - help coarse to fine search algorithms to find objects in a picture  
Integral image - also know as summed area table, a grid whose values are the sum of values between the origin and value's coordinate X  
Interest point - also known as keypoints/matching point/corner/feature are points in the image which are distinct from other points in the image  
Interpolation - also known as upsampling, changes the resolution of the image  
Invariant to X - when a function isn't affected when X changes  
Laplacian of Gaussian (LoG) - the second derivative of DoG  
Location (interest point) selection - interest points are corners where the change in intensity is in more then one direction and blobs, areas around which the intensity is different from the intensity in the blob  
Octave pyramid also known as a Laplacian pyramid or Gaussian pyramid, constructed by blurring the original image and then subsampling it with a rate of 2  
Scale selection - an interest point is going to be found at some scale level within the scale space pyramid  
Schwarz's theorem - it doesn't matter what you partial derivate first, second partial derivatives are the same regardless of order  
Second moment matrix - also known as structure tensor  
Trace - sum of values on the main diagonal (from up and left to down and right) of the square matrix  
U-SURF - Upright Speeded Up Robust Features, a SURF variant who isn't in plane rotation invariant, but faster and equally precise on pictures that rotate only around the vertical axis  
