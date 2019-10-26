## SURF

SURF stands for Speeded Up Robust Features, a work which created both a distinct point detector and an "area around the point" descriptor.  
It is based on many previous papers which SURF combined to create a precise, fast and robust detector and descriptor algorithms.  
SURF's descriptor and detector are both scale and in-plane rotation invariant (meaning neither rotation nor zooming will affect the feature vectors). However, for sake of speed, rotational invariance can be sacrificed (which would create an Upright SURF algorithm).  
It is possible to make the SURF descriptor invariant to affine transformations using affine normalisation of the ellipse, but this comes at a great cost: speed.  
SURF doesn't use colour information.  

### Related works

Harris detector is based on eigenvalues of the second moment matrix.  
Hessian (Hessian matrix determinant) and Laplacian (Hessian matrix trace) can detect blob-like structures.  
Using the Hessian determinant to select the distinct points and Hessian trace to select the scale, Schmid made a scale invariant, highly repeatable detector.  
SIFT approximated Laplacian of Gaussian (LoG) by a Difference of Gaussian (DoG).  
Hessian based detectors are more stable and repeatable then Harris based detectors.
SURF uses the Hessian determinant to select both the scale and location.  
SIFT outperforms all other descriptors because it computes a histogram of local gradients around the distinct point.  
Integral images are used to greatly speed up calculations.  
SUFT uses the Hessian trace to speed up the matching process.  

### Interest point detection

A picture is a grid of pixel of different intensities.
An integral image, also knows as summed area table, is a grid of the same size, but has a value calculated by summing all the pixel intensities from the point of origin to the coordinate X.  

Picture with pixel intensities I(X):  
```
+-----+-----+  
| 090 | 055 |   I(0,0) = 90  
+-----+-----+  
| 000 | 155 |   I(1,1) = 155  
+-----+-----+  

Integral image S(I):       Formula:  
+-----+-----+              +-----+-----+  
| 090 | 145 |              | -S  | +S  |  
+-----+-----+              +-----+-----+  
| 090 | 300 |              | +S  | +Ix |  
+-----+-----+              +-----+-----+  
S(I(x,y)) = - S(x-1,y-1) + S(x,y-1) + S(x,y-1) + S(x-1,y-1)  
S(I(0,0)) = - 0          + 0        + 0        + 90       = 90  
S(I(1,0)) = - 0          + 90       + 0        + 0        = 90  
S(I(0,1)) = - 0          + 0        + 90       + 55       = 145  
S(I(1,1)) = - 90         + 145      + 90       + 155      = 300  
```

If you want to calculate the sum of intensities in the area ABCD, use the formula:  
```
+-----+-----+  
| 090 | 055 |  
+-----A-----B  
| 000 | 155 |  
+-----C-----D  
S(ABCD) = S(A) + S(D) - S(B) - S(C)  
        = 90   + 300  - 145  - 90  
        = 155  
```

### Hessian matrix interest points

SURF detects blob structures by looking where the Hessian matrix determinant is at its maximum.  
Hessian matrix determinant is used for scale selection as well.  
Gaussian second order partial derivative is approximated with a box filter.  
The box filter speeds up the calculation of the Hessian determinant.  
Due to the approximation, a weight w is added to the determinant equation.  
The approximated determinant of the Hessian shows where the blob structures are most likely located.  

### Scale space representation

In order to find distinct points that are invariant to scale, an image pyramid is constructed from the original image.  
The pyramid is made up of blurred images of different sizes and blurriness.  
The pyramid is divided into octaves.  
An octave dictates the filter sampling step, and each octave is divided into levels which dictate the filter size.  
SURF uses box filters of different sizes which in turn approximate the sigma of the Gaussian blurring function by creating blurred images.  
The size of the first box filter is 9*9 (or 15*15 with the original image doubled in size through interpolation) and it increases in size as it moves through octave levels and octaves themselves.  
The first and last level within each octave are used for comparison with other levels in the octave and cannot contain Hessian determinant maxima.  

You can look up box filters in the SURF paper, pages 4 and 5.  
o is octave number (1,2,3 or 4), i is level within an octave (1,2,3 or 4).  
Filter size: N*N, N = 3*L, L = 2^o * i + 1  
Starting filter size: 9*9 (or 15*15)  
Sampling step in octave: 2^(o-1) (every pixel, then every second pixel, then every fourth ...)  

### Interest point localisation

To find interest points invariant to scale, non maximas are suppressed in a 3*3*3 pixel area (9 pixels in the level above, 9 pixels in the level below and 9 pixels at the same level are compared to each other).  
It suppresses all values of the Hessian determinant that are not the maximum.  
The maxima are then interpolated in scale and image space as proposed in reference 5.  

Non maxima suppression in a 3*3*3 space.  
X denotes the pixels being compared to each other, while C denotes the center of the space.  
Octave level size is not correct!  

```
Octave 1, level 1:    Octave 1, level 2:    Octave 1, level 3:  
+---+---+---+---+---+ +---+---+---+---+---+ +---+---+---+---+---+  
| o | o | o | o | o | | o | o | o | o | o | | o | o | o | o | o |  
+---+---+---+---+---+ +---+---+---+---+---+ +---+---+---+---+---+  
| o | X | X | X | o | | o | X | X | X | o | | o | X | X | X | o |  
+---+---+---+---+---+ +---+---+---+---+---+ +---+---+---+---+---+  
| o | X | X | X | o | | o | X | C | X | o | | o | X | X | X | o |  
+---+---+---+---+---+ +---+---+---+---+---+ +---+---+---+---+---+  
| o | X | X | X | o | | o | X | X | X | o | | o | X | X | X | o |  
+---+---+---+---+---+ +---+---+---+---+---+ +---+---+---+---+---+  
| o | o | o | o | o | | o | o | o | o | o | | o | o | o | o | o |  
+---+---+---+---+---+ +---+---+---+---+---+ +---+---+---+---+---+  
```

### Interest point invariant to rotation

Find pixels withing the 6*s radius of the interest point.  
Pass a Haar filter over those pixels.  
The Haar filter calculates the response in x and y direction.  
Haar filter size is 4*s by 4*s and it samples every sth pixel.  
Filter responses are then weighted according to how distant they are from the interest point with a Gaussian function, sigma = 2*s.  
The responses are plotted on a graph and a sliding window size pi/3 (or 60 degrees) sums the responses within the window to create an orientation vector.  
The orientation vector that is the longest is the dominant orientation vector.  
If we don't want to create interest points that are invariant to scale, we can skip this step.  
When it is skipped, the algorithm is called USURF (Upright SURF).  
It works well on images that rotate only around the vertical axis.  

Every box filter has a scale factor s and it is equal to sigma of the Gaussian function the box filter approximates.  
s = 0,4*L, where L = 2^o * i + 1  
Size of area: 6*s circle radius around the interest point  
Sampling step: s  
Haar filter size: 4*s by 4*s  
Weight with a Gaussian, sigma: 2*s  
Sliding window size: 60 degrees  
Choose the longest orientation vector.  

### Interest point description

SURF describes the area around the interest point the size of 20*s by 20*s.  
That region is then split into 16 equally sized smaller subregions which make a 4 by 4 grid.  
Haar filter size 2*s by 2*s then calculates the response at every 5 by 5 spaced sample point.  
Haar responses are weighted with a Gaussian function, sigma 3.3*s.  
Then the response values are rotated to match the dominant orientation vector.  
The response values and absolute response values are summed to create a 4 feature vector, but this is done for each subregion which means the vector size is 16*4, 64 feature vector.  
SURF is invariant to bias in illumination because the Haar filters are invariant to it and it is invariant to contract because the feature vectors are turned into unit vectors.  
It is possible to make an extended version of the SURF vector by dividing values into positive and negative ones.  

Size of area: 20*s by 20*s  
Subregions: 4 by 4, 16 subregions  
Sampling step: every 5 by 5 pixels  
Haar filter size: 2*s by 2*s  
Weight with a Gaussian, sigma: 3.3*s  
Sum the response values for each subregion to create a feature vector.  

### Matching feature vectors

SURF uses the sign of the trace of the Hessian matrix to prevent light blobs on dark background being matched with dark blobs on light background.  
It essentially create one more feature in the feature vector.  
